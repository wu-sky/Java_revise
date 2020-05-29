package com.sky.innerclass;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 吴世凯
 * 邮箱：
 * 日期：5/25/2020
 *
 * 建造者模式(静态内部类的应用)
 *
 *
 */
public class Computer {


    private String cpu;
    private String mainBoard;
    private String hardDisk;
    private String displayCard;
    private String power;
    private String memory;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getDisplayCard() {
        return displayCard;
    }

    public void setDisplayCard(String displayCard) {
        this.displayCard = displayCard;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", displayCard='" + displayCard + '\'' +
                ", power='" + power + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }

    //使用内部类给自己造个对象出来
    public Computer(ComputerBuilder computerBuilder){
        this.cpu = computerBuilder.cpu;
        this.mainBoard = computerBuilder.mainBoard;
        this.hardDisk = computerBuilder.hardDisk;
        this.displayCard = computerBuilder.displayCard;
        this.power = computerBuilder.power;
        this.memory = computerBuilder.memory;
    }

    public static class ComputerBuilder{

        private String cpu;
        private String mainBoard;
        private String hardDisk;
        private String displayCard;
        private String power;
        private String memory;
        public ComputerBuilder buildCPU(String cpu){
            this.cpu = cpu;
            return this;
        }
        public ComputerBuilder buildMainBoard(String mainBoard){
            this.mainBoard = mainBoard;
            return this;
        }
        public ComputerBuilder buildHardDisk(String hardDisk){
            this.hardDisk = hardDisk;
            return this;
        }
        public ComputerBuilder buildDisplayCard(String displayCard){
            this.displayCard = displayCard;
            return this;
        }
        public ComputerBuilder buildPower(String power){
            this.power = power;
            return this;
        }
        public ComputerBuilder buildMemory(String memory){
            this.memory = memory;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }

    }

}

class TestBuilder {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder().buildCPU("酷睿I7").
                buildMainBoard("华硕主板").
                buildHardDisk("西数硬盘").
                buildMemory("美商海盗船").
                build();
        System.out.println(computer);


    }
}