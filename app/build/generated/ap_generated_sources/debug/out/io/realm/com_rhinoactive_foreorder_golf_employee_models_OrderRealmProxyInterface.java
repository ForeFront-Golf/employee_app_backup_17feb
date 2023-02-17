package io.realm;


public interface com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface {
    public Integer realmGet$orderId();
    public void realmSet$orderId(Integer value);
    public com.rhinoactive.foreorder_golf_employee.models.User realmGet$user();
    public void realmSet$user(com.rhinoactive.foreorder_golf_employee.models.User value);
    public String realmGet$currentState();
    public void realmSet$currentState(String value);
    public Integer realmGet$orderNum();
    public void realmSet$orderNum(Integer value);
    public Integer realmGet$clubId();
    public void realmSet$clubId(Integer value);
    public Integer realmGet$menuId();
    public void realmSet$menuId(Integer value);
    public Boolean realmGet$delivery();
    public void realmSet$delivery(Boolean value);
    public Boolean realmGet$fulfilled();
    public void realmSet$fulfilled(Boolean value);
    public Float realmGet$priceTotal();
    public void realmSet$priceTotal(Float value);
    public Float realmGet$priceTotalWithTax();
    public void realmSet$priceTotalWithTax(Float value);
    public Float realmGet$taxAmount();
    public void realmSet$taxAmount(Float value);
    public Integer realmGet$quantity();
    public void realmSet$quantity(Integer value);
    public Integer realmGet$userId();
    public void realmSet$userId(Integer value);
    public java.util.Date realmGet$createdAt();
    public void realmSet$createdAt(java.util.Date value);
    public java.util.Date realmGet$modifiedAt();
    public void realmSet$modifiedAt(java.util.Date value);
    public String realmGet$memberCode();
    public void realmSet$memberCode(String value);
    public RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> realmGet$orderItems();
    public void realmSet$orderItems(RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> value);
}
