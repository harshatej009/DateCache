package harsh.rane.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import harsh.rane.model.Element;

@Service
public class OrderService {

	@Async
	 public void saveOrderDetails(Element element) throws InterruptedException {
	 Thread.sleep(2000);
	 System.out.println(element.getElement_name());
	 }

	@Async
	 public CompletableFuture<String> saveOrderDetailsFuture(Element element) throws InterruptedException {
	 System.err.println("Execute method with return type + " + Thread.currentThread().getName());
	 String result = "Hello From CompletableFuture. Order: ".concat(element.getElement_name());
	 Thread.sleep(5000);
	 arrayConversion();
	 return CompletableFuture.completedFuture(result);
	 }

	@Async
	 public CompletableFuture<String> compute(Element element) throws InterruptedException {
		System.err.println("Execute method with return type + " + Thread.currentThread().getName());
	 String result = "Hello From CompletableFuture CHAIN. Order: ".concat(element.getElement_name());
	 Thread.sleep(5000);
	 return CompletableFuture.completedFuture(result);
	 }
	
	
	
	private void arrayConversion() {
		String[] arry = new String[] {"harsh", "tej"};
		 List al = Arrays.asList(arry);
		 System.out.println(al);
		 
		 String[] arry3 = new String[al.size()];
		 String[] arry2 = (String[]) al.toArray(arry3);
		 System.out.println(arry[0]);
		 System.out.println(arry2[0]);
	}
	
}

