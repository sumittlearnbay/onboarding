# DevWorkflow Onboarding (Spring Boot)

Run:
```bash
mvn clean package
java -jar target/onboarding-1.0.0.jar
# or
mvn spring-boot:run
```
Open http://localhost:8080/index.html

Endpoints:
- POST /api/auth/register
- POST /api/auth/login
- GET/POST/PUT/DELETE /api/tasks
- GET/POST/PUT/DELETE /api/requirements
- GET/POST/PUT /api/code-reviews (+ /{id}/diff)
- POST /api/ai/suggestions  (SSE stream via WebFlux)
- GET /api/ai/conversations
- GET /api/integrations
- POST /api/integrations/{service}/sync
- POST /api/integrations/webhook/github
- GET /api/settings , PUT /api/settings
- GET /api/dashboard/overview
- WebSocket STOMP: /ws (topic /topic/updates)
- SSE heartbeat: /sse/stream

JWT is enforced via a simple filter; whitelist covers /api/auth/** and docs.
