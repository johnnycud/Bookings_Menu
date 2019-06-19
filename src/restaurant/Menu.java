/**
 * 
 */
package restaurant;

/**
 * Author jCudd
 * Date 19/06/2019
 * Menu and its attributes
 * 
 */
public class Menu {
	
	protected static Menu itemName;
	protected static Menu price;
	protected static Menu quantity ;
	protected static String itemName2;
	private static String price2;
	private static String quantity2;

	public Menu(Menu itemName, Menu price,Menu quantity) {
		Menu.itemName = itemName;
		Menu.price = price;
		Menu.quantity = quantity;
	}

	public Menu(String itemName2, String price2, String quantity2) {
		Menu.itemName2 = itemName2;
		Menu.setPrice2(price2);
		Menu.setQuantity2(quantity2);
	}

	public static Menu getItemName() {
		return itemName;
	}

	public void setItemName(Menu itemName) {
		Menu.itemName = itemName;
	}
	
	public static Menu getPrice() {
		return price;
	}

	public void setPrice(Menu price) {
		Menu.price = price;
	}

	public static Menu getQuantity() {
		return quantity;
	}

	public void setQuantity(Menu quantity) {
		Menu.quantity = quantity;
	}
	
	public void display() {
		System.out.println( "Menu [Item Name= " + itemName + "Price= " + price+ "Quantity= " + quantity  +  "]");
		
	}



	/**
	 * @return the price2
	 */
	public static String getPrice2() {
		return price2;
	}

	/**
	 * @param price2 the price2 to set
	 */
	public static void setPrice2(String price2) {
		Menu.price2 = price2;
	}



	/**
	 * @return the quantity2
	 */
	public static String getQuantity2() {
		return quantity2;
	}

	/**
	 * @param quantity2 the quantity2 to set
	 */
	public static void setQuantity2(String quantity2) {
		Menu.quantity2 = quantity2;
	}



	public static class Food extends Menu{
	
		public Food(String starter, String mainCourse, String dessert) {
			super(itemName,  price, quantity);
			Food.starter = starter;
			Food.mainCourse = mainCourse;
			Food.dessert = dessert;
		}
		/**
		 * @return the starter
		*/
		public String getStarter() {
			return starter;
		}
		/**
		 * @param starter the starter to set
		 */
		public void setStarter(String starter) {
			Food.starter = starter;
		}
		/**
		 * @return the mainCourse
		 */
		public String getMainCourse() {
			return mainCourse;
		}
		/**
		 * @param mainCourse the mainCourse to set
		 */
		public void setMainCourse(String mainCourse) {
			Food.mainCourse = mainCourse;
		}
		/**
		 * @return the dessert
		 */
		public String getDessert() {
			return dessert;
		}
		/**
		 * @param dessert the dessert to set
		 */
		public void setDessert(String dessert) {
			Food.dessert = dessert;
		}
	
		private static String starter = "";
		private static String mainCourse = "";
		private static String dessert = "";
	
		public void display() {
			System.out.println( "Food [Starter= " + starter + "Main Course= " + mainCourse+ "Dessert= " + dessert  +  "]");
		
		}
	}

	public static class Drink extends Menu{
	
		public Drink(String beer, String wine, String softDrink) {
			super(itemName,  price, quantity);
			Drink.beer = beer;
			Drink.wine = wine;
			Drink.softDrink = softDrink;
		}
		/**
		 * @return the starter
		*/
		public String getBeer() {
			return beer;
		}
		/**
		 * @param starter the starter to set
		 */
		public void setStarter(String beer) {
			Drink.beer = beer;
		}
		/**
		 * @return the mainCourse
		 */
		public String getWine() {
			return wine;
		}
		/**
		 * @param mainCourse the mainCourse to set
		*/
		public void setMainCourse(String wine) {
			Drink.wine = wine;
		}
		/**
		 * @return the dessert
		 */
		public String getSoftDrink() {
			return softDrink;
		}
		/**
		 * @param dessert the dessert to set
		 */
		public void setDessert(String softDrink) {
			Drink.softDrink = softDrink;
		}
		private static String beer = "";
		private static String wine = "";
		private static String softDrink = "";
	
		public void display() {
			System.out.println( "Drink [Beer = " + beer + "Wine = " + wine+ "Soft Drink = " + softDrink  +  "]");
		
		}
	
	}

}
