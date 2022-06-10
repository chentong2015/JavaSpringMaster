package com.example.main.masterbeans;

// XML Namespace: 一种避免名称冲突的方式, 在不同的app中混合xml时可能会出现名称不统一
// 下面两个table所使用的元素来自不同的名称空间，所以不造成冲突
// <h:table>
// <h:tr>
// <h:td>Apples</h:td>
// </h:tr>
// </h:table>
//
// <f:table>
// <f:tr>
// <f:td>Apples</f:td>
// </f:tr>
// </f:table>
public class BeanNamespaces {

	// 在beans.xml中添加指定的名称空间
	// xmlns:c="http://www.springframework.org/schema/c"
	// xmlns:p="http://www.springframework.org/schema/p"

	// C Namespace:
	// <constructor-arg ...> 将构造器的参数传递改成通过c名称空间来实现
	// <bean id="myBean" c:fieldName="value" ../> 和传入构造器的参数名称一致
	// <bean id="myBean" c:referenceAnotherBean-ref="anotherBean" ../>

	// P Namespace:
	// <property name="postalCode" value="100"> 将setter改成通过P名称空间来实现
	// <bean ... p:postalCode="100" ..> 使用bean elements attributes 调Setter

}
