package org.se.lab.compileTimeMetaprogramming

@Finders(tableName="USER", finders=["username", "group"])
class User {
}

@Finders(tableName="CAR", finders=["make", "model"])
class Car {
}

class CompileTimeMetaprogramming {
	public static void main(String[] args) {
		User.findByUsername("Carly")
		User.findByUsername("Administrators")
		Car.findByMake("Audi")
		Car.findByModel("Golf")
	}
}
