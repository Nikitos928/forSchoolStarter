package com.digdes.school;

import com.digdes.school.requests.InsertMethods;
import com.digdes.school.requests.SearchMethods;

import java.util.*;

public class JavaSchoolStarter {

    public JavaSchoolStarter() {

    }

    private List<Map<String, Object>> db = new ArrayList<>();

    InsertMethods insertMethods = new InsertMethods();

    SearchMethods searchMethods = new SearchMethods();

    public List<Map<String, Object>> execute(String request) throws Exception {

        String path = request.substring(0, 6).toUpperCase();
        switch (path) {
            case ("INSERT") -> insert(request);
            case ("UPDATE") -> update(request);
            case ("DELETE") -> delete(request);
            case ("SELECT") -> {
                return select(request);
            }
            default -> throw new Exception("Такой фунцкии пока нет");
        }
        return db;
    }

    public void insert(String request) throws Exception {

        Map<String, Object> line = new HashMap<>();

        request = request.replace("INSERT VALUES", "").replace(" ", "");

        String lastName = insertMethods.getString(request);
        Boolean active = insertMethods.getActive(request);
        Long id = insertMethods.getLong(request, "id");
        Long age = insertMethods.getLong(request, "age");
        Double cost = insertMethods.getDouble(request, "cost");

        line.put("lastName", lastName);
        line.put("active", active);
        line.put("id", id);
        line.put("age", age);
        line.put("cost", cost);
        db.add(line);
    }

    public void update(String request) throws Exception {
        request = request.replace("UPDATE VALUES", "").replace(" ", "");

        Set<Map<String, Object>> filterSet;

        if (request.contains("WHERE")){
            String where = request.substring(request.indexOf("WHERE") + 5);
            if (request.contains("AND")) {
                filterSet = searchMethods.deleteAndSelectMapAnd(db, where);
            } else {
                filterSet = searchMethods.deleteAndSelectMapOr(db, where);
            }
        } else {
            filterSet = new HashSet<>(db);
        }

        if (request.contains("WHERE")) {
            request = request.substring(0, request.indexOf("WHERE"));
        }

        String lastName = insertMethods.getString(request);

        Long id = insertMethods.getLong(request, "id");
        Long age = insertMethods.getLong(request, "age");
        Double cost = insertMethods.getDouble(request, "cost");

        for (Map<String, Object> stringObjectMap : filterSet) {
            if (lastName != null) {
                db.remove(stringObjectMap);
                stringObjectMap.put("lastName", lastName);
            }
            if (cost != null) {
                db.remove(stringObjectMap);
                stringObjectMap.put("cost", cost);
            }
            if (request.contains("active")) {
                Boolean active = insertMethods.getActive(request);
                db.remove(stringObjectMap);
                stringObjectMap.put("active", active);
            }
            if (id != null) {
                db.remove(stringObjectMap);
                stringObjectMap.put("id", id);
            }
            if (age != null) {
                db.remove(stringObjectMap);
                stringObjectMap.put("age", age);
            }
        }
        db.addAll(filterSet);
    }

    public void delete(String request) throws Exception {
        request = request.replace("DELETE WHERE", "").replace(" ", "");
        if (request.contains("AND")) {
            for (Map<String, Object> stringObjectMap : searchMethods.deleteAndSelectMapAnd(db, request)) {
                db.remove(stringObjectMap);
            }
        } else {
            for (Map<String, Object> stringObjectMap : searchMethods.deleteAndSelectMapOr(db, request)) {
                db.remove(stringObjectMap);
            }
        }
    }

    public List<Map<String, Object>> select(String request) throws Exception {
        if (request.contains("AND")) {
            request = request.replace("SELECT WHERE", "").replace(" ", "");
            return new ArrayList<>(searchMethods.deleteAndSelectMapAnd(db, request));
        } else {
            request = request.replace("SELECT WHERE", "").replace(" ", "");
            return new ArrayList<>(searchMethods.deleteAndSelectMapOr(db, request));
        }
    }

}
