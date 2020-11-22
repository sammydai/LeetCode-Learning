package com.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Package: com.learning
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/22 14:22
 */

public class CompareTest {

	public static void main(String[] args) {
		List<Dog> list= new ArrayList<>();
		list.add(new Dog(5, "DogA"));
		list.add(new Dog(7, "DogC"));
		list.add(new Dog(6, "DogB"));
		Collections.sort(list, new Comparator<Dog>() {
			@Override
			public int compare(Dog o1, Dog o2) {
				if (o1.age < o2.age) {
					return -1;
				} else if (o1.age > o2.age) {
					return 1;
				}
				return 0;
			}
		});
		 System.out.println("给狗狗按照年龄倒序："+list);
	}
}

class Dog{
	public int age;
	public String name;
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
}
