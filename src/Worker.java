public class Worker {
    final private OnTaskDoneListener callback;
    final private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i <= 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " completed with an error!");
            } else {
                callback.onDone("Task " + i + " is done!");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}
