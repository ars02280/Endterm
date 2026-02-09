Product Management API
Project Overview
A Spring Boot REST service for product management using a layered architecture and JPA.

REST API Documentation
Base URL: http://localhost:8080/api/products

GET	/	List all products
POST	/	Add a product
DELETE	/{id}	Remove a product

Example of work with Postman :
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 21_43_49" src="https://github.com/user-attachments/assets/30a6b535-7c9f-4b9c-92b9-a76f60870639" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 21_43_49" src="https://github.com/user-attachments/assets/30a6b535-7c9f-4b9c-92b9-a76f60870639" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 22_15_58" src="https://github.com/user-attachments/assets/b5b5a79d-e57f-46d0-a585-f0cc437738e7" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 22_15_58" src="https://github.com/user-attachments/assets/b5b5a79d-e57f-46d0-a585-f0cc437738e7" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 22_16_08" src="https://github.com/user-attachments/assets/0d1d37bf-06fd-45fb-b990-7d48d57a141c" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 22_16_08" src="https://github.com/user-attachments/assets/0d1d37bf-06fd-45fb-b990-7d48d57a141c" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 22_16_14" src="https://github.com/user-attachments/assets/4f5142ae-1538-4197-acde-d5fb4a38f0eb" />
<img width="1920" height="1040" alt="http___localhost_8080_api_categories - Ars&#39;s Workspace 09 02 2026 22_16_14" src="https://github.com/user-attachments/assets/4f5142ae-1538-4197-acde-d5fb4a38f0eb" />



Design Patterns & Principles
Singleton: Spring Beans (Services/Controllers) are singletons.

Factory: JpaRepository generates database implementations.

Builder: Simplifies object creation.

SOLID: Ensures Single Responsibility and Dependency Injection.

System Architecture
Follows a Controller -> Service -> Repository -> Database flow.

Database Schema
Table: products

Columns: id (PK), name (String), price (Double).

How to Run
Open in IntelliJ IDEA.

Run Application.java.

Test via http://localhost:8080/api/products.

Reflection
The project applies SOLID and DRY principles to create a scalable Java backend. It successfully integrates Spring Data JPA for automated database management.
