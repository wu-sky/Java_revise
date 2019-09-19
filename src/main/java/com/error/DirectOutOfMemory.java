package com.error;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 堆外内存溢出 一般与nio有关
 */
public class DirectOutOfMemory {

	public static void main(String[] args){
		List<ByteBuffer> buffers = new ArrayList<>();
		while(true){
			ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 1024);
			buffers.add(buffer);
		}

	}
}





/*
 *用户：sky-吴
 *日期：2019/8/28
 */