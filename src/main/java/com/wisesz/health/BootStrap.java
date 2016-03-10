package com.wisesz.health;

import com.jfinal.core.JFinal;

public class BootStrap {

	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8085, "/", 5);
	}
}
