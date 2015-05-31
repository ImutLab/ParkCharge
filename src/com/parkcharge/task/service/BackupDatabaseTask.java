package com.parkcharge.task.service;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenjie.util.DateUtils;
import com.chenjie.util.MySQLUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.parkcharge.sys.entity.Log;
import com.parkcharge.sys.service.LogService;

@Service
public class BackupDatabaseTask {
	@Autowired
	private ComboPooledDataSource dataSource;
	@Autowired
	private LogService logService;

	/**
	 * 定时备份数据库
	 */
	public void backupDB() {
		System.out.println("备份数据库中...");
		Date dt = new Date();
		Log log = new Log();
		log.setActionDate(DateUtils.formatDate(dt));
		log.setActionName("自动备份");
		log.setManager("admin");
		try {
			String filePath = getCurrentPath();
			filePath = filePath.substring(0, filePath.length() - 2);
			filePath = filePath.substring(0, filePath.replace("\\", "/").lastIndexOf("/"));

			String newFileName = filePath + "/backup/ParkCharge/";
			String sqlFolderName = DateUtils.formatDateAsyyyymmdd(dt);
			String sqlFileName = DateUtils.formatTimeAshhmiss(dt) + ".sql";
			newFileName += sqlFolderName + "/" + sqlFileName;
			newFileName = newFileName.replace("\\", "/");

			MySQLUtils.backupDB(dataSource.getUser(), dataSource.getPassword(), "parkcharge", newFileName);
			log.setOtherInfo("备份成功!文件名:" + newFileName);
		} catch (Exception e) {
			log.setOtherInfo("备份失败!");
			e.printStackTrace();
		} finally {
			logService.add(log);
			System.out.println("备份数据库完成...");
		}

	}

	/**
	 * 获取当前项目的路径
	 * 
	 * @return
	 */
	public String getCurrentPath() {
		return new File("").getAbsolutePath();
	}

	/**
	 * 测试延时调用任务
	 */
	public void testDelay() {
		System.out.println("测试延时任务中...");
	}

}
