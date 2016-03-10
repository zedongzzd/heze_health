package com.wisesz.health;

import com.jfinal.core.JFinal;

public class BootStrap {

	public static void main(String[] args) {
		//启动项目
		JFinal.start("src/main/webapp", 8085, "/", 5);
	}
}
