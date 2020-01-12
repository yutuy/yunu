/******************************************************************************
 * Copyright (C) 2016 Wuhan Water Elephant Co.Ltd All Rights Reserved. 
 * 本软件为上海迈志科技有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.study.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Module: CosClientUtil.java
 * 
 * @author Ibis
 * @since JDK 1.8
 * @version 1.0
 * @description: <描述>
 */
@Component
public class CosClientUtil {

	protected static Logger log = LoggerFactory.getLogger(CosClientUtil.class);

	@Value("${cos.secretid}")
	public String secretid;

	@Value("${cos.secretkey}")
	public String secretkey;

	@Value("${cos.appid}")
	public String appid;

	@Value("${cos.regionid}")
	public String regionid;

	@Value("${cos.bucketname1}")
	public String name;
	// 暂时没用到
	public String KEY = "MyFile1/zookeeper-3.4.8.tar.gz";
	// 暂时没用到
	public String KEY01 = "MyFile1/1.jpg";

	/**
	 * 初始化CosClient相关配置， appid、accessKey、secretKey、region
	 * 
	 * @return
	 */
	public COSClient getCosClient() {
		// 1 初始化用户身份信息(secretId, secretKey)
		COSCredentials cred = new BasicCOSCredentials(secretid, secretkey);
		// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
		// clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
		ClientConfig clientConfig = new ClientConfig(new Region(regionid));
		// 3 生成cos客户端
		COSClient cosClient = new COSClient(cred, clientConfig);
		// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
		// String bucketName = BUCKETNAME;
		return cosClient;
	}

	/**
	 * 上传文件
	 * 
	 * @return //绝对路径和相对路径都OK
	 */
	public String uploadFile(File localFile, String key) {
		String bucketName = name + "-" + appid;
		// String key = new Date().getTime() + ".png";
		// File localFile = new File("E:\\testpic\\testliushuai.png");
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
		String url1 = "";
		// 设置存储类型, 默认是标准(Standard), 低频(standard_ia),一般为标准的
		putObjectRequest.setStorageClass(StorageClass.Standard);

		COSClient cc = getCosClient();
		try {
			PutObjectResult putObjectResult = cc.putObject(putObjectRequest);
			// putobjectResult会返回文件的etag
			String etag = putObjectResult.getETag();
			Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
			URL url = cc.generatePresignedUrl(bucketName, key, expiration);
			url1 = url.toString();

		} catch (CosServiceException e) {
			e.printStackTrace();
		} catch (CosClientException e) {
			e.printStackTrace();
		}
		// 关闭客户端
		cc.shutdown();
		return url1;
	}

	/**
	 * 下载文件
	 * 
	 * @param bucketName
	 * @param key
	 * @return
	 */
	public String downLoadFile(String bucketName, String key) {
		File downFile = new File("E:\\software\\1.jpg");
		COSClient cc = getCosClient();
		GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);

		ObjectMetadata downObjectMeta = cc.getObject(getObjectRequest, downFile);
		cc.shutdown();
		String etag = downObjectMeta.getETag();
		return etag;
	}

	/**
	 * 删除文件
	 * 
	 * @param bucketName
	 * @param key
	 */
	public void deleteFile(String key) {
		COSClient cc = getCosClient();
		try {
			cc.deleteObject(name + "-" + appid, key);
		} catch (CosClientException e) {
			e.printStackTrace();
		} finally {
			cc.shutdown();
		}

	}

	/**
	 * 创建桶
	 * 
	 * @param bucketName
	 * @return
	 * @throws CosClientException
	 * @throws CosServiceException
	 */
	public Bucket createBucket(String bucketName) throws CosClientException, CosServiceException {
		COSClient cc = getCosClient();
		Bucket bucket = null;
		try {
			bucket = cc.createBucket(bucketName);
		} catch (CosClientException e) {
			e.printStackTrace();
		} finally {
		}
		return bucket;
	};

	/**
	 * 删除桶
	 * 
	 * @param bucketName
	 * @throws CosClientException
	 * @throws CosServiceException
	 */
	public void deleteBucket(String bucketName) throws CosClientException, CosServiceException {
		COSClient cc = getCosClient();
		try {
			cc.deleteBucket(bucketName);
		} catch (CosClientException e) {
			e.printStackTrace();
		} finally {
		}
	};

	/**
	 * 判断桶是否存在
	 * 
	 * @param bucketName
	 * @return
	 * @throws CosClientException
	 * @throws CosServiceException
	 */
	public boolean doesBucketExist(String bucketName) throws CosClientException, CosServiceException {
		COSClient cc = getCosClient();
		boolean bucketExistFlag = cc.doesBucketExist(bucketName);
		return bucketExistFlag;
	};

	/**
	 * 查看桶文件
	 * 
	 * @param bucketName
	 * @return
	 * @throws CosClientException
	 * @throws CosServiceException
	 */
	public ObjectListing listObjects(String bucketName) throws CosClientException, CosServiceException {
		COSClient cc = getCosClient();

		// 获取 bucket 下成员（设置 delimiter）
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
		listObjectsRequest.setBucketName(bucketName);
		// 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
		listObjectsRequest.setPrefix("");
		// 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
		listObjectsRequest.setDelimiter("/");
		// 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
		listObjectsRequest.setMarker("");
		// 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
		listObjectsRequest.setMaxKeys(100);

		ObjectListing objectListing = cc.listObjects(listObjectsRequest);
		// 获取下次 list 的 marker
		String nextMarker = objectListing.getNextMarker();
		// 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
		boolean isTruncated = objectListing.isTruncated();
		List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
		for (COSObjectSummary cosObjectSummary : objectSummaries) {
			// get file path
			String key = cosObjectSummary.getKey();
			// get file length
			long fileSize = cosObjectSummary.getSize();
			// get file etag
			String eTag = cosObjectSummary.getETag();
			// get last modify time
			Date lastModified = cosObjectSummary.getLastModified();
			// get file save type
			String StorageClassStr = cosObjectSummary.getStorageClass();
		}
		return objectListing;
	}

	/**
	 * 查询一个 Bucket 所在的 Region。
	 * 
	 * @param bucketName
	 * @return
	 * @throws CosClientException
	 * @throws CosServiceException
	 */
	public String getBucketLocation(String bucketName) throws CosClientException, CosServiceException {
		COSClient cosClient = getCosClient();
		// bucket 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
		String location = cosClient.getBucketLocation(bucketName);
		return location;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("111");
		CosClientUtil aa = new CosClientUtil();
		// aa.uploadFile();
		// downLoadFile(BUCKETNAME , KEY);
		// deleteFile(BUCKETNAME , KEY01);
		// createBucket("sunjunxian01-1251782781");
		// deleteBucket();
		// doesBucketExist("sunjunxian01-1251782781");
		// System.out.println(listObjects(BUCKETNAME));
		// System.out.println("BUCKETNAME的位置：" + getBucketLocation(BUCKETNAME));
	}

	public String getIndex(String key) {
		String url1 = "";
		COSClient cc = getCosClient();
		Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
		URL url = cc.generatePresignedUrl(name + "-" + appid, key, expiration);
		if (url != null) {
			url1 = url.toString();
		}
		System.out.println(url.toString());
		return url1;
	}

	public static File inputStreamToFile(MultipartFile multipartFile, File file) {
		String fileName = multipartFile.getOriginalFilename();
		file = new File(fileName);
		OutputStream out = null;
		try {
			// 获取文件流，以文件流的方式输出到新文件
			// InputStream in = multipartFile.getInputStream();
			out = new FileOutputStream(file);
			byte[] ss = multipartFile.getBytes();
			for (int i = 0; i < ss.length; i++) {
				out.write(ss[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return file;
	}

	//直接传文件字节组
	public static File inputStreamToFile(byte[] bys, String fileName) {
//		String fileName = multipartFile.getOriginalFilename();
		File file = new File(fileName);
		OutputStream out = null;
		try {
			// 获取文件流，以文件流的方式输出到新文件
			// InputStream in = multipartFile.getInputStream();
			out = new FileOutputStream(file);
			byte[] ss = bys;
			for (int i = 0; i < ss.length; i++) {
				out.write(ss[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}

}
