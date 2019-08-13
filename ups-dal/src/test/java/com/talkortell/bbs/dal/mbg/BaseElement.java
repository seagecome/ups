package com.talkortell.bbs.dal.mbg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseElement {
	private String domainEncryptContent;
	private String newAnnotation;
	private String domainPackage;
	private String importAnnotation;
	private String xmlSourceContent;
	private String xmlAddContent;
	private String xmlDynamicSql;
	private String xmlDynamicAddContent;
	
	public BaseElement(String encryptField, String selfTypeHandler) {
		this.domainEncryptContent="private String "+encryptField;
		this.newAnnotation="@ColumnType(typeHandler="+selfTypeHandler+".class)";
		this.domainPackage="package com.talkortell.bbs.domain.mysql.ups;";
		this.importAnnotation="import tk.mybatis.mapper.annotation.ColumnType;";
		this.xmlSourceContent="property=\""+encryptField+"\"";
		this.xmlAddContent=" typeHandler=\""+selfTypeHandler+"\"";
		this.xmlDynamicSql=encryptField+",jdbcType=VARCHAR";
		this.xmlDynamicAddContent=",typeHandler="+selfTypeHandler;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseElement [");
		if (domainEncryptContent != null)
			builder.append("domainEncryptContent=").append(domainEncryptContent).append(", ");
		if (newAnnotation != null)
			builder.append("newAnnotation=").append(newAnnotation).append(", ");
		if (domainPackage != null)
			builder.append("domainPackage=").append(domainPackage).append(", ");
		if (importAnnotation != null)
			builder.append("importAnnotation=").append(importAnnotation).append(", ");
		if (xmlSourceContent != null)
			builder.append("xmlSourceContent=").append(xmlSourceContent).append(", ");
		if (xmlAddContent != null)
			builder.append("xmlAddContent=").append(xmlAddContent).append(", ");
		if (xmlDynamicSql != null)
			builder.append("xmlDynamicSql=").append(xmlDynamicSql).append(", ");
		if (xmlDynamicAddContent != null)
			builder.append("xmlDynamicAddContent=").append(xmlDynamicAddContent);
		builder.append("]");
		return builder.toString();
	}
}
