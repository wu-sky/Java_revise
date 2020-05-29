package com.sky.enumerate;

/*
 *用户：sky-吴
 *日期：2020/4/19
 */


/**
 * 信号灯常量
 */
public enum Signal {

	GREEN, //静态的对象
	YELLOW,
	RED,
	BLACK();
	private String name;
	private int index;
	// 构造方法
	private Signal() {
		this.setName("没有颜色, 请你自己设置...");
	}

	/**
	 * Inferred annotations available. Full signature:
	 * @Contract(pure = true)  public String getName()
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.index+"---"+this.name;
	}

	//自定义方法
	public void meaning(Signal signal) {
		Signal color = signal;
		switch (color) {
			case GREEN:
				color = Signal.GREEN;
				System.out.println("绿灯");
				break;
			case YELLOW:
				color = Signal.YELLOW;
				System.out.println("黄灯");
				break;
			case RED:
				color = Signal.RED;
				System.out.println("红灯");
				break;
			case BLACK:
				color = Signal.BLACK;
				System.out.println("灯坏了");
				break;
		}

	}
	public static void main(String[] args){

		System.out.println(Signal.RED==null);
		System.out.println(Signal.RED.equals("RED"));
		System.out.println(	Signal.RED.getClass() +"\n"+ "RED".getClass());
		System.out.println(RED.getName());
		RED.setName("红色");
		System.out.println(RED.getName());

		System.out.println(RED.ordinal());



	}
}


