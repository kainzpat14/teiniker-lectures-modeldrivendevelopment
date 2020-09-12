package org.se.lab



// like ruby, groovy allows runtime metaprogramming by intercepting function calls, allowing us to
// generate functionality on the fly. For example, GORM, Groovys OR-Mapper uses this to automatically generate finder
// methods similarly to the code below
abstract class Finder {
	protected abstract String getTableName()


	def methodMissing(String name, Object args) {
		if(name.startsWith("findBy") && args.size() == 1) {
			System.out.println("dynamically creating method: $name on ${this.class}")
			def cachedMethod = { value ->
				String columnName = name.toLowerCase()-'findby'
				System.out.println("SELECT * FROM "+getTableName()+" WHERE "+columnName+" = '"+value+"';")
			}
			this.metaClass."$name" = cachedMethod
			cachedMethod(args[0])
		} else {
			throw new MissingMethodException(name, this.class, args)
		}
	}
}


class UserFinder extends Finder {

	@Override
	protected String getTableName() {
		return "User"
	}

}

class CarFinder extends Finder {
	@Override
	protected String getTableName() {
		return "Car"
	}
}

class RuntimeMetaprogramming {
	public static void main(String[] args) {
		ExpandoMetaClass.enableGlobally()
		new UserFinder().findByUsername("Charly")
		new UserFinder().findByUsername("August")
		new CarFinder().findByMake("Audi")
		new CarFinder().findByMake("VW")
	}

}


