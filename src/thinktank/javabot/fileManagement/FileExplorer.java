package thinktank.javabot.fileManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileExplorer {

	static String fileName = "script3.py";
	static String fileExtension = ".py";
	
	public static void checkFor(String directoryPath) {
		File dir = new File(directoryPath);
		
		if(!dir.exists())
			createDirectory(dir);
	}
	
	public static void createDirectory(File directory)
	{
		directory.mkdir();
	}
	
	public static List<File> getListFile(String directoryPath)
	{
		List<File> files = new LinkedList<File>();
		
		File dir = new File(directoryPath);
	    File[] filesInFolder = dir.listFiles(new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.toLowerCase().endsWith(fileExtension);
	        }
	    });
		
		/*filesInFolder = Files.walk(Paths.get(directoryPath))
		       .filter(Files::isRegularFile)
		       .map(Path::toFile)
		       .collect(Collectors.toList());*/
	    
	    files = Arrays.asList(filesInFolder);
		
		return files;
	}
	
	public static void saveFile(String filePath, String newText)
	{
		try (
			Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filePath), "utf-8"))) {
			writer.write(newText);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createFile(String filePath, String textToWrite)
	{
		try (
			Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filePath), "utf-8"))) {
			writer.write(textToWrite);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createFile(String directoryPath, String fileName, String textToWrite)
	{
		createFile(directoryPath + "/" + fileName, textToWrite);
	}
	
	public static String readFile(String path)
	{
		byte[] encoded = null;
		String fileContent = null;
		
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fileContent = new String(encoded, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileContent;
	}
}