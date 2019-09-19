package com.generic.genericUpperBound;

import java.util.ArrayList;
import java.util.List;

/*
 *用户：sky-吴
 *日期：2019/9/3
 */
public class Canvas {

	public void draw1(List<Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
	}

	public void draw2(List<?> shapes) {
		for (Object o : shapes) {
			Shape s = (Shape) o;
			s.draw(this);
		}
	}

	/**
	 * 泛型通配符上限 <? extends Shape>表示 shape类型的各种未知子类
	 *
	 * @param shapes
	 */
	public void draw3(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
	}

	public static void main(String[] args) {

		Circle c = new Circle();
		Rectangle r = new Rectangle();
		List<Shape> list=new ArrayList<>();
		list.add(c);
		list.add(r);
		Canvas canvas = new Canvas();
		canvas.draw3(list);
	}
}
