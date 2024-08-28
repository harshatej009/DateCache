package harsh.rane.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import harsh.rane.dao.ElementDao;
import harsh.rane.entity.ElementEntity;
import harsh.rane.model.Element;
import harsh.rane.service.ElementToElementEntityTransformer;
import harsh.rane.service.OrderService;

@RestController
public class DataCacheController {

	@Autowired
	ElementDao elementdao;
	
	@Autowired
	OrderService orderService;

	
	@GetMapping(path = "/elements")
	public List<ElementEntity> fetchElements() {
	return elementdao.getElements();
	}
	
	@PostMapping(path = "/elements")
	 public ResponseEntity<Void> addElements(@RequestBody Element element) throws InterruptedException, ParseException {
	 elementdao.addElements(new ElementToElementEntityTransformer().apply(element));
	 return ResponseEntity.ok(null);
	 }
	
	@PostMapping(path = "/process")
	 public ResponseEntity<Void> process(@RequestBody Element element) throws InterruptedException {
	 System.out.println("PROCESSING STARTED");
	 orderService.saveOrderDetails(element);
	 return ResponseEntity.ok(null);
	 }

	@PostMapping(path = "/process/future")
	 public ResponseEntity<String> processFuture(@RequestBody Element element) throws InterruptedException, ExecutionException {
	 System.out.println("PROCESSING STARTED");
	 CompletableFuture<String> orderDetailsFuture = orderService.saveOrderDetailsFuture(element);
	 String result = orderDetailsFuture.get();  // get method blocks the thread
	 return ResponseEntity.ok(result);
	 }

	@PostMapping(path = "/process/future/chain")
	 public ResponseEntity<CompletableFuture<Void>> processFutureChain(@RequestBody Element element) throws InterruptedException, ExecutionException {
	 System.out.println("PROCESSING STARTED");
	 CompletableFuture<String> computeResult = orderService.compute(element);
	 CompletableFuture<Void> s = computeResult.thenApply(result -> result).thenAccept(System.out::println);  // thenApply/ thenAccept are unblocking methods
	 return ResponseEntity.ok(s.thenApply(result -> result));
	 }

}