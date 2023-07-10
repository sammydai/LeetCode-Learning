package com.learning.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.hashcode
 * @Description: hashCode method
 * 重写equals hashcode方法的原因
 * equals保证对象的内容、属性相同
 * hashcode保证对象的hash计算值相同-->在map中的位置相同
 * @Author: Sammy
 * @Date: 2022/1/24 14:38
 */

public class HashCodeTest {
	public static void main(String[] args) {
		Map<Person, Integer> hashMap = new HashMap<>();
		Person zhangsan = new Person("zhangsan", 27);
		Person zhangsan1 = new Person("zhangsan", 27);
		System.out.println(zhangsan.equals(zhangsan1));
		System.out.println("zhangsan hashcode:" + zhangsan.hashCode());
		System.out.println("zhangsan1 hashcode:" + zhangsan1.hashCode());
		hashMap.put(zhangsan, 888);
		hashMap.put(zhangsan1, 777);
		System.out.println("get value:" + hashMap.get(new Person("zhangsan", 27)));
		// hashMap.forEach((key,val)-> {
		// 	System.out.println(key);
		// 	System.out.println(val);
		// });
	}

	private static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Person person = (Person) o;

			if (age != person.age) return false;
			return name != null ? name.equals(person.name) : person.name == null;
		}

		@Override
		public int hashCode() {
			int result = name != null ? name.hashCode() : 0;
			result = 31 * result + age;
			return result;
		}
	}
}
