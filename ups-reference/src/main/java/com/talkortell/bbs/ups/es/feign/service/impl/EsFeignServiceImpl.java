package com.talkortell.bbs.ups.es.feign.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.talkortell.bbs.ups.es.common.EsJestClient;
import com.talkortell.bbs.ups.es.feign.req.FeignQueryMatchNameRequest;
import com.talkortell.bbs.ups.es.feign.service.IEsFeignService;

import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EsFeignServiceImpl implements IEsFeignService {

	private static final String INDEXNAME="pys";
	private static final String INDEXTYPE="_doc";
	
	@Override
	public List<String> queryMatchNameList(FeignQueryMatchNameRequest feignQueryMatchNameRequest) {
		List<String> matchNames = new ArrayList<String>();
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		MatchPhraseQueryBuilder mpqBuilder = new MatchPhraseQueryBuilder("hotelName", "东京");//param1
		sourceBuilder.query(mpqBuilder);
		sourceBuilder.from(0);
		sourceBuilder.size(10);
		Search search = new Search.Builder(sourceBuilder.toString()).addIndex(INDEXNAME).addType(INDEXTYPE).build();
		
		SearchResult result = null;
		try {
			result = EsJestClient.getClient().execute(search);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Hit<JSONObject, Void>> hits = result.getHits(JSONObject.class);
		for(Hit<JSONObject, Void> hit : hits) {
			JSONObject source = hit.source;
			log.info("===hit===elem={}", source.toJSONString());
			String hotelName = (String) source.get("hotelName");
			log.info("===hotelNeme={}", hotelName);
			matchNames.add(hotelName);
		}
		return matchNames;
	}

}
