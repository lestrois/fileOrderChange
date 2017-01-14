package org.richardqiao.fileorderchange;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileOrderChange {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("D:/Pic/birthday");
		File[] files = dir.listFiles();
		//Read File list by modified date
		
		Arrays.sort(files, new Comparator<File>(){
			public int compare(File f1, File f2){
				return Long.valueOf(f1.lastModified()).compareTo(Long.valueOf(f2.lastModified()));
			}
		});
		
		for(int i = 0; i < files.length; i++){
			System.out.println(files[i].getName() + " -> " + ("00" + i).substring(("00" + i).length() - 3));
			files[i].renameTo(new File("D:/Pic/birthday/" + ("00" + i).substring(("00" + i).length() - 3) + ".jpg"));
		}
	}

}
