package com.fintech.recon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @PostMapping("/reconcile")
    public ResponseEntity> reconcilePayment(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestBody Map<String, Object> transaction) {

        String batchId = UUID.randomUUID().toString();
        return ResponseEntity.ok(Map.of(
            "batchId", batchId,
            "idempotencyKey", idempotencyKey,
            "status", "RECONCILED",
            "timestamp", Instant.now().toString()
        ));
    }
}
