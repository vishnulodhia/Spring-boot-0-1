package com.springBootLearning.spring_boot_0_1.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Subscription {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long subscriptionId;

        private String type;

        private Integer sessionLimit;
}
