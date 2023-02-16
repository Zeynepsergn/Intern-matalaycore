package tr.gov.gib.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Store implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id", nullable = false)
    private Integer storeId;
    @Basic
    @Column(name = "manager_staff_id", nullable = false)
    private Short managerStaffId;
    @Basic
    @Column(name = "address_id", nullable = false)
    private Short addressId;
    @Basic
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Short getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Short managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(storeId, store.storeId) && Objects.equals(managerStaffId, store.managerStaffId) && Objects.equals(addressId, store.addressId) && Objects.equals(lastUpdate, store.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, managerStaffId, addressId, lastUpdate);
    }
}
