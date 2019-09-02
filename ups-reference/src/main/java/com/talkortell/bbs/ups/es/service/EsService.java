package com.talkortell.bbs.ups.es.service;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.talkortell.bbs.ups.es.common.EsJestClient;

import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EsService {
	private static final String INDEXNAME="pys";
	private static final String INDEXTYPE="_doc";
	public void search() {
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		MatchPhraseQueryBuilder mpqBuilder = new MatchPhraseQueryBuilder("hotelName", "东京");//param1
		sourceBuilder.query(mpqBuilder);
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
		}
	}
}
