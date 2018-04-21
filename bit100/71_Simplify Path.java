// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"

// click to show corner cases.

// Corner Cases:

 

 

// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".


class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/+");
        //Stack
        Stack<String> stack = new Stack<>();
        //several conditions
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!paths[i].equals(".") && !paths[i].equals("")) {
                stack.push(paths[i]);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}