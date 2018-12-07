package com.hp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the attachment database table.
 * 
 */
@Entity
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="absolute_path")
	private String absolutePath;

	@Column(name="file_name")
	private String fileName;

	@Column(name="file_type")
	private String fileType;

	@Column(name="function_type")
	private String functionType;

	@Column(name="module_id")
	private BigInteger moduleId;

	@Column(name="module_type")
	private String moduleType;

	private String name;

	private String url;

	private int version;

	public Attachment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAbsolutePath() {
		return this.absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public BigInteger getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(BigInteger moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleType() {
		return this.moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}