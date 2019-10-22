package com.pking.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import net.minidev.json.JSONObject;

public class FastDFSClient {
	private static final String CONFIG_FILENAME = "E:\\GitHub\\spring-cloud\\pking-parent\\pking-provider02\\src\\main\\resources\\fdfs_client.conf";
	private static final String GROUP_NAME = "market1";
	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient storageClient = null;

	static {
		try {
			ClientGlobal.init(CONFIG_FILENAME);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public FastDFSClient() throws Exception {
		trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
		trackerServer = trackerClient.getConnection();
		storageServer = trackerClient.getStoreStorage(trackerServer);
		;
		storageClient = new StorageClient(trackerServer, storageServer);
	}

	/**
	 * 上传文件
	 * 
	 * @param file     文件对象
	 * @param fileName 文件名
	 * @return
	 */
	public String[] uploadFile(File file, String fileName) {
		return uploadFile(file, fileName, null);
	}

	/**
	 * 上传文件
	 * 
	 * @param file     文件对象
	 * @param fileName 文件名
	 * @param metaList 文件元数据
	 * @return
	 */
	public String[] uploadFile(File file, String fileName, Map<String, String> metaList) {
		try {
			byte[] buff = IOUtils.toByteArray(new FileInputStream(file));
			NameValuePair[] nameValuePairs = null;
			if (metaList != null) {
				nameValuePairs = new NameValuePair[metaList.size()];
				int index = 0;
				for (Iterator<Map.Entry<String, String>> iterator = metaList.entrySet().iterator(); iterator
						.hasNext();) {
					Map.Entry<String, String> entry = iterator.next();
					String name = entry.getKey();
					String value = entry.getValue();
					nameValuePairs[index++] = new NameValuePair(name, value);
				}
			}
			return storageClient.upload_file(GROUP_NAME, buff, fileName, nameValuePairs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取文件元数据
	 * 
	 * @param fileId 文件ID
	 * @return
	 */
	public Map<String, String> getFileMetadata(String groupname, String fileId) {
		try {
			NameValuePair[] metaList = storageClient.get_metadata(groupname, fileId);
			if (metaList != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				for (NameValuePair metaItem : metaList) {
					map.put(metaItem.getName(), metaItem.getValue());
				}
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除文件
	 * 
	 * @param fileId 文件ID
	 * @return 删除失败返回-1，否则返回0
	 */
	public int deleteFile(String groupname, String fileId) {
		try {
			return storageClient.delete_file(groupname, fileId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 下载文件
	 * 
	 * @param fileId  文件ID（上传文件成功后返回的ID）
	 * @param outFile 文件下载保存位置
	 * @return
	 */
	public int downloadFile(String groupName, String fileId, File outFile) {
		FileOutputStream fos = null;
		try {
			byte[] content = storageClient.download_file(groupName, fileId);
			fos = new FileOutputStream(outFile);
			InputStream ips = new ByteArrayInputStream(content);
			IOUtils.copy(ips, fos);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return -1;
	}

	/**
	 * 获取访问服务器的token，拼接到地址后面
	 *
	 * @param filepath      文件路径 group1/M00/00/00/wKgzgFnkTPyAIAUGAAEoRmXZPp876.jpeg
	 * @param httpSecretKey 密钥
	 * @return 返回token，如： token=078d370098b03e9020b82c829c205e1f&ts=1508141521
	 */
	public static String getToken(String filepath, String httpSecretKey) {
		// unix seconds
		int ts = (int) Instant.now().getEpochSecond();
		// token
		String token = "null";
		try {
			token = ProtoCommon.getToken(getFilename(filepath), ts, httpSecretKey);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		sb.append("token=").append(token);
		sb.append("&ts=").append(ts);

		return sb.toString();
	}

	private static String getFilename(String filepath) {
		return filepath.substring(filepath.lastIndexOf("/")+1);
	}

	public static void main(String[] args) throws Exception {
		FastDFSClient client = new FastDFSClient();
		/*
		 * File file = new File("D:\\123.jpg"); String[] result =
		 * client.uploadFile(file, "jpg"); System.out.println(result.length);
		 * System.out.println(result[0]); System.out.println(result[1]);
		 */
		/**
		 * 2 group1 M00/00/00/wKgfgF2uEjWAQaTuAACBZl8ZduQ244.jpg
		 * 
		 * 2 group1 M00/00/00/wKgfgF2uF86AOfNmAACBZl8ZduQ943.jpg
		 */
		// File outFile = new File("D:\\789666.jpg");
		// client.downloadFile("group1", "M00/00/00/wKgfgF2uEjWAQaTuAACBZl8ZduQ244.jpg",
		// outFile);
		// System.out.println(JSONObject
		// .toJSONString(client.getFileMetadata("group1",
		// "M00/00/00/wKgfgF2uEjWAQaTuAACBZl8ZduQ244.jpg")));
		System.out.println(getToken("M00/00/00/wKgfgF2uF86AOfNmAACBZl8ZduQ943.jpg","FASTDFS1234567890"));
	}
}
