public class PathNormalizer {

    private static final String CURRENT_DIR = ".";
    private static final String PARENT_DIR = "..";
    private static final String SEPARATOR = "/";
    private static final String EMPTY = "";

    public static String normalize(String path) {

        if (!isValidPath(path)) {
            return null;
        }

        String[] parts = splitPath(path);
        String[] stack = processParts(parts);
        return buildResult(stack);
    }

    private static boolean isValidPath(String path) {
        if (path == null) {
            return false;
        }
        if (!path.startsWith(CURRENT_DIR)) {
            return false;
        }
        return true;
    }

    private static String[] splitPath(String path) {
        return path.split(SEPARATOR);
    }

    private static String[] processParts(String[] parts) {

        String[] stack = new String[parts.length];
        int size = 0;

        for (String part : parts) {

            if (shouldSkip(part)) {
                continue;
            }

            if (isParent(part)) {
                size = removePart(size);
            } else {
                stack[size] = part;
                size++;
            }
        }

        return trimStack(stack, size);
    }

    private static boolean shouldSkip(String part) {
        if (part.equals(EMPTY)) {
            return true;
        }
        if (part.equals(CURRENT_DIR)) {
            return true;
        }
        return false;
    }

    private static boolean isParent(String part) {
        if (part.equals(PARENT_DIR)) {
            return true;
        }
        return false;
    }

    private static int removePart(int size) {
        if (size > 0) {
            return size - 1;
        }
        return 0;
    }
    private static String[] trimStack(String[] stack, int size) {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack[i];
        }
        return result;
    }
    private static String buildResult(String[] stack) {

        if (stack.length == 0) {
            return CURRENT_DIR;
        }

        String result = CURRENT_DIR;

        for (String dir : stack) {
            result += SEPARATOR + dir;
        }

        return result;
    }
}
