public class AutoPolicyTest{
  public static void main(String[] args){
    AutoPolicy policy1 = new AutoPolicy(1226, "Tsuru", "NY");
    AutoPolicy policy2 = new AutoPolicy(1234, "Sentra", "NA");

    policyInNoFaultState(policy1);
    policyInNoFaultState(policy2);
  }

  public static void policyInNoFaultState(AutoPolicy policy){
    System.out.println("La poliza de auto: ");
    System.out.printf("Cuenta: #%s, Modelo: %s, Estado: %s %nEl estado es no-fault: %s%n%n", policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(), policy.isNoFaultState() ? "si": "no");
  }
}
