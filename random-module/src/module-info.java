import com.example.random.service.RandomNumberGeneratorService;
import com.example.random.service.business.SecureRandomNumberGeneratorService;
import com.example.random.service.business.StandardRandomNumberGeneratorService;

module com.example.random {
	exports com.example.random.service;
	provides RandomNumberGeneratorService 
	with StandardRandomNumberGeneratorService, SecureRandomNumberGeneratorService;
}