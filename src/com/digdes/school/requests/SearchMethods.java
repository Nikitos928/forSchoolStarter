package com.digdes.school.requests;

import java.util.*;

public class SearchMethods {

    public Set<Map<String, Object>> deleteAndSelectMapOr(List<Map<String, Object>> newDb, String request) throws Exception {

        InsertMethods insertMethods = new InsertMethods();

        StringBuilder sb = new StringBuilder(request);


        String lastName = insertMethods.getString(request);
        Long id = insertMethods.getLong(request, "id");
        Long age = insertMethods.getLong(request, "age");
        Double cost = insertMethods.getDouble(request, "cost");
        Boolean active;


        Set<Map<String, Object>> deleteList = new HashSet<>();

        for (Map<String, Object> stringObjectMap : newDb) {
            if ((Long) stringObjectMap.get("id") != null) {
                if (request.contains("'id'=")) {
                    if (((Long) stringObjectMap.get("id")).equals(id)) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'id'!=")) {
                    if (!((Long) stringObjectMap.get("id")).equals(id)) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'id'>=")) {
                    if ((Long) stringObjectMap.get("id") >= id) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'id'<=")) {
                    if ((Long) stringObjectMap.get("id") <= id) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'id'>")) {
                    if ((Long) stringObjectMap.get("id") >= id) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'id'<")) {
                    if ((Long) stringObjectMap.get("id") <= id) {
                        deleteList.add(stringObjectMap);
                    }
                }

            }
            if (stringObjectMap.get("lastName") != null) {
                if (request.contains("'lastName'=")) {
                    if (stringObjectMap.get("lastName").toString().equals(lastName)) {
                        deleteList.add(stringObjectMap);
                    }
                }

                if (request.contains("'lastName'!=")) {
                    if (!Objects.equals(stringObjectMap.get("lastName").toString(), lastName)) {
                        deleteList.add(stringObjectMap);
                    }
                }

                if (request.contains("'lastName'like")) {
                    if (!lastName.contains("%")) {
                        if (stringObjectMap.get("lastName").toString().contains(lastName)) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                    if (lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .endsWith(lastName.replaceFirst("%", ""))) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                    if (lastName.endsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .startsWith(lastName.replaceFirst("%", ""))) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                    if (lastName.endsWith("%") && lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .contains(lastName.replace("%", ""))) {
                            deleteList.add(stringObjectMap);
                        }
                    }

                }

                if (request.contains("'lastName'ilike")) {
                    if (!lastName.contains("%")) {
                        if (stringObjectMap.get("lastName").toString().toLowerCase().contains(lastName.toLowerCase())) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                    if (lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString().toLowerCase()
                                .endsWith(lastName.replaceFirst("%", "").toLowerCase())) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                    if (lastName.endsWith("%")) {
                        if (stringObjectMap.get("lastName").toString().toLowerCase()
                                .startsWith(lastName.replaceFirst("%", "").toLowerCase())) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                    if (lastName.endsWith("%") && lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString().toLowerCase()
                                .contains(lastName.replace("%", "").toLowerCase())) {
                            deleteList.add(stringObjectMap);
                        }
                    }
                }

            }


            if (((Double) stringObjectMap.get("cost")) != null) {
                if (request.contains("'cost'=")) {
                    if (((Double) stringObjectMap.get("cost")).equals(cost)) {
                        deleteList.add(stringObjectMap);
                    }

                }
                if (request.contains("'cost'!=")) {
                    if (!((Double) stringObjectMap.get("cost")).equals(cost)) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'cost'>=")) {
                    if ((Double) stringObjectMap.get("cost") >= cost) {
                        deleteList.add(stringObjectMap);
                    }
                }

                if (request.contains("'cost'<=")) {
                    if ((Double) stringObjectMap.get("cost") <= cost) {
                        deleteList.add(stringObjectMap);
                    }
                }

                if (request.contains("'cost'>")) {
                    if ((Double) stringObjectMap.get("cost") >= cost) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'cost'<")) {
                    if ((Double) stringObjectMap.get("cost") <= cost) {
                        deleteList.add(stringObjectMap);
                    }
                }
            } else if (request.contains("'cost'") && stringObjectMap.get("cost") == null) {
                deleteList.add(stringObjectMap);
            }
            if ((Long) stringObjectMap.get("age") != null) {
                if (request.contains("'age'=")) {
                    if (((Long) stringObjectMap.get("age")).equals(age)) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'age'!=")) {
                    if (!((Long) stringObjectMap.get("age")).equals(age)) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'id'>=")) {
                    if ((Long) stringObjectMap.get("age") >= age) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'age'<=")) {
                    if ((Long) stringObjectMap.get("age") <= age) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'age'>")) {
                    if ((Long) stringObjectMap.get("age") >= age) {
                        deleteList.add(stringObjectMap);
                    }
                }
                if (request.contains("'age'<")) {
                    if ((Long) stringObjectMap.get("age") <= age) {
                        deleteList.add(stringObjectMap);
                    }
                }
            }
            if (request.contains("active")) {
                active = insertMethods.getActive(request);
                if ((Boolean) stringObjectMap.get("active") != null) {
                    if ((Boolean) stringObjectMap.get("active") == active) {
                        deleteList.add(stringObjectMap);
                    }
                }
            }
        }

        return deleteList;

    }



    public Set<Map<String, Object>> deleteAndSelectMapAnd(List<Map<String, Object>> newDb, String request) throws Exception {

        Integer sumAnd = count(request, "AND") + 1;

        InsertMethods insertMethods = new InsertMethods();

        StringBuilder sb = new StringBuilder(request);

        String lastName = insertMethods.getString(request);
        Long id = insertMethods.getLong(request, "id");
        Long age = insertMethods.getLong(request, "age");
        Double cost = insertMethods.getDouble(request, "cost");
        Boolean active;

        Map<Map<String, Object>, Integer> deleteList = new HashMap<>();

        for (Map<String, Object> stringObjectMap : newDb) {
            if ((Long) stringObjectMap.get("id") != null) {
                if (request.contains("'id'=")) {
                    if (((Long) stringObjectMap.get("id")).equals(id)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'id'!=")) {
                    if (!((Long) stringObjectMap.get("id")).equals(id)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'id'>=")) {
                    if ((Long) stringObjectMap.get("id") >= id) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'id'<=")) {
                    if ((Long) stringObjectMap.get("id") <= id) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'id'>")) {
                    if ((Long) stringObjectMap.get("id") >= id) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'id'<")) {
                    if ((Long) stringObjectMap.get("id") <= id) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
            }
            if (stringObjectMap.get("lastName") != null) {
                if (request.contains("'lastName'=")) {
                    if (stringObjectMap.get("lastName").toString().equals(lastName)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'lastName'!=")) {
                    if (!Objects.equals(stringObjectMap.get("lastName").toString(), lastName)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'lastName'like")) {
                    if (!lastName.contains("%")) {
                        if (stringObjectMap.get("lastName").toString().contains(lastName)) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                    if (lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString().endsWith(lastName
                                .replaceFirst("%", ""))) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                    if (lastName.endsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .startsWith(lastName.replaceFirst("%", ""))) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                    if (lastName.endsWith("%") && lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName")
                                .toString().contains(lastName.replace("%", ""))) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                }
                if (request.contains("'lastName'ilike")) {
                    if (!lastName.contains("%")) {
                        if (stringObjectMap.get("lastName").toString().toLowerCase().contains(lastName.toLowerCase())) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                    if (lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .toLowerCase().endsWith(lastName.replaceFirst("%", "").toLowerCase())) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                    if (lastName.endsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .toLowerCase().startsWith(lastName.replaceFirst("%", "").toLowerCase())) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                    if (lastName.endsWith("%") && lastName.startsWith("%")) {
                        if (stringObjectMap.get("lastName").toString()
                                .toLowerCase().contains(lastName.replace("%", "").toLowerCase())) {
                            if (deleteList.containsKey(stringObjectMap)){
                                deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                            } else {
                                deleteList.put(stringObjectMap, 1);
                            }
                        }
                    }
                }
            }
            if (((Double) stringObjectMap.get("cost")) != null) {
                if (request.contains("'cost'=")) {
                    if (((Double) stringObjectMap.get("cost")).equals(cost)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'cost'!=")) {
                    if (!((Double) stringObjectMap.get("cost")).equals(cost)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'cost'>=")) {
                    if ((Double) stringObjectMap.get("cost") >= cost) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }

                if (request.contains("'cost'<=")) {
                    if ((Double) stringObjectMap.get("cost") <= cost) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }

                if (request.contains("'cost'>")) {
                    if ((Double) stringObjectMap.get("cost") >= cost) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'cost'<")) {
                    if ((Double) stringObjectMap.get("cost") <= cost) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
            } else if (request.contains("'cost'") && stringObjectMap.get("cost") == null) {
                if (deleteList.containsKey(stringObjectMap)){
                    deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                } else {
                    deleteList.put(stringObjectMap, 1);
                }
            }
            if ((Long) stringObjectMap.get("age") != null) {
                if (request.contains("'age'=")) {
                    if (((Long) stringObjectMap.get("age")).equals(age)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'age'!=")) {
                    if (!((Long) stringObjectMap.get("age")).equals(age)) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'id'>=")) {
                    if ((Long) stringObjectMap.get("age") >= age) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'age'<=")) {
                    if ((Long) stringObjectMap.get("age") <= age) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'age'>")) {
                    if ((Long) stringObjectMap.get("age") >= age) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
                if (request.contains("'age'<")) {
                    if ((Long) stringObjectMap.get("age") <= age) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
            }
            if (request.contains("active")) {
                active = insertMethods.getActive(request);
                if ((Boolean) stringObjectMap.get("active") != null) {
                    if ((Boolean) stringObjectMap.get("active") == active) {
                        if (deleteList.containsKey(stringObjectMap)){
                            deleteList.put(stringObjectMap, deleteList.get(stringObjectMap) +1);
                        } else {
                            deleteList.put(stringObjectMap, 1);
                        }
                    }
                }
            }
        }

        Set<Map<String, Object>> newList = new HashSet<>();

        for (Map<String, Object> k : deleteList.keySet()) {
            if (deleteList.get(k).equals(sumAnd) )  {
                newList.add(k);
            }
        }
        return newList;
    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
