List of Annotations

Annotation	Description

@SpringBootApplication	Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.

@RestController	Combines @Controller and @ResponseBody to simplify the creation of RESTful web services.

@RequestMapping	Provides routing information and is used to map web requests to specific handler classes or methods.

@GetMapping	A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

@PostMapping	A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).

@PutMapping	A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT).

@DeleteMapping	A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE).

@PatchMapping	A composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PATCH).

@Autowired	Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.

@Component	Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

@Service	Indicates that an annotated class is a "Service" (e.g., a business service facade).

@Repository	Indicates that an annotated class is a "Repository" (e.g., a Data Access Object or DAO).

@Configuration	Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

@Bean	Indicates that a method produces a bean to be managed by the Spring container.

@Value	Indicates a default value expression for the annotated element.

@PropertySource	Provides a convenient and declarative mechanism for adding a PropertySource to Spring's Environment.

@EnableAutoConfiguration	Enables Spring Boot’s auto-configuration mechanism.