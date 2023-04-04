package com.viking.poc;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class User {
  private String fullName;
  private Double budgetAmount;
}
