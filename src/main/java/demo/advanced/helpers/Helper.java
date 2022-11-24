package demo.advanced.helpers;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import demo.advanced.framework.DriverManager;

public class Helper {

	public static void takeScreenshots(String failedTestName) {

		File screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(
					System.getProperty("user.dir") + "\\results\\failedScreenshots\\" + failedTestName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
//	 private static byte[] takeFullPageScreenShotAsByte() throws IOException {
//	        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
//	                .takeScreenshot(webDriver);
//
//	        BufferedImage originalImage = fpScreenshot.getImage();
//
//	        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//	            ImageIO.write(originalImage, "png", baos);
//	            baos.flush();
//	            return baos.toByteArray();
//	        }
//	    }

//	public static void takeFullDesktopScreenshot(String fileName) {
//
////		byte[] imageBytes = ((ChromeDriver) DriverManager.getDriver()).getFullPageScreenshotAs(OutputType.BYTES);
////		Files.write(Paths.get(RESULT_FILENAME), imageBytes);
//		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
//				.takeScreenshot(DriverManager.getDriver());
//		try {
//			ImageIO.write(s.getImage(), "PNG",
//					new File(System.getProperty("user.dir") + "\\results\\failedScreenshots\\" + fileName + ".jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
