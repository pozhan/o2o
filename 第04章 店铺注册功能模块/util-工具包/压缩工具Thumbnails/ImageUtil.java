package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader()
			.getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间格式化的格式
	private static final Random r = new Random();
	
	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makerDirPath(targetAddr);//创建目录
		String relativeAddr = targetAddr + realFileName + extension;//相对路径
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(new File(basePath +"/ttt.jpg")).size(200,200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建目录路径所涉及到的目录，即/home/tupian/image/ttt.jpg
	 * home tupian image三个目录都会自动创建
	 * @param targetAddr
	 */
	private static void makerDirPath(String targetAddr) {
		String realFileParentPath = FileUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFilename = cFile.getOriginalFilename();
		return originalFilename.substring(originalFilename.lastIndexOf("."));
	}
	/**
	 * 生成随机文件名，当前年月日 小时分钟秒钟+五位随机数
	 * @return
	 */
	private static String getRandomFileName() {
		// 获取随机的五位数
		int rannum = r.nextInt(89999)+10000;
		//当前时间
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}

	public static void main(String[] args) throws IOException {
		
		Thumbnails.of(new File(basePath +"/ttt.jpg")).size(200,200)
		.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
		.outputQuality(0.8f).toFile(basePath +"/ttt1.jpg");

	}

}
