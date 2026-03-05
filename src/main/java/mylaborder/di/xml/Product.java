package mylaborder.di.xml;

public class Product {
	//변수 선언
	private String id;
	private String name;
	private long price;
	
	//기본 생성자(Setter 주입)
	public Product() {
		System.out.println(this.getClass().getName() + "기본생성자 호출");
	}
	
	// 모든 필드를 포함한 생성자 (Constructor 주입)
    public Product(String id, String name, int price) {
    	  System.out.println(this.getClass().getName() + "오버로딩생성자 호출");
        this.id = id;
        this.name = name;
        this.price = price;             
    }
    
    // Setter 메서드들 (XML의 <property>에서 사용)
    public void setId(String id) { 
    	System.out.println("setId() 메서드 호출됨" + id);
    	this.id = id; 
    	}
    
    public void setName(String name) { 
    	System.out.println("setName" + name);
    	this.name = name;
    	}
    
    public void setPrice(int price) { 
    	System.out.println("setPrice" + price);
    	this.price = price; 
    	}

    // Getter 메서드들 (테스트 코드에서 사용)
    public String getId() { 
    	return id; 
    	}
    
    public String getName() {
    	return name; 
    	}
    
    public long getPrice() { 
    	return price; 
    	}
}
