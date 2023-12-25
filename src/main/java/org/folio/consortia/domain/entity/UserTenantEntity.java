package org.folio.consortia.domain.entity;

import org.folio.consortia.domain.entity.base.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user_tenant")
public class UserTenantEntity extends AuditableEntity {

  @Id
  private UUID id;
  private UUID userId;
  private String username;
  @ManyToOne
  @JoinColumn(name = "tenant_id", referencedColumnName = "id")
  private TenantEntity tenant;

  private Boolean isPrimary;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserTenantEntity that = (UserTenantEntity) o;
    return Objects.equals(id, that.id)
      && Objects.equals(userId, that.userId)
      && Objects.equals(username, that.username)
      && Objects.equals(tenant, that.tenant)
      && Objects.equals(isPrimary, that.isPrimary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, username, tenant, isPrimary);
  }
}
