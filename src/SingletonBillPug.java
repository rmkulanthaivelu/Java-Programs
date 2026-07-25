
class SingletonBillPug {

    private SingletonBillPug() {
    }

    private static class Holder {
        private static final SingletonBillPug INSTANCE =
                new SingletonBillPug();
    }

    public static SingletonBillPug getInstance() {
        return Holder.INSTANCE;
    }
}