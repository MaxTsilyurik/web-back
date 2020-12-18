package com.example.webback.business.utils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StreamUtils {
    private StreamUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T, R> List<R> filterMapDistinctCollect(List<T> list, Predicate<T> filter, Function<T, R> function) {
        return filterMap(list, filter, function)
                .distinct()
                .collect(Collectors.toList());
    }

    public static <T, R> List<R> filterMapCollect(List<T> list, Predicate<T> filter, Function<T, R> function) {
        return filterMap(list, filter, function)
                .collect(Collectors.toList());
    }

    public static <T, R> List<R> mapCollect(List<T> list, Function<T, R> function) {
        return map(list, function).collect(Collectors.toList());
    }

    public static <T> List<T> filterCollect(List<T> list, Predicate<T> filter) {
        return filter(list, filter)
                .collect(Collectors.toList());
    }

    public static <T,R> List<R> mapFilterCollect(List<T> list, Function<T,R> function, Predicate<R> predicate){
        return map(list,function)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static <T, R> Stream<R> filterMap(List<T> list, Predicate<T> filter, Function<T, R> function) {
        return filter(list, filter)
                .map(function);
    }

    private static <T> Stream<T> filter(List<T> list, Predicate<T> filter) {
        return list
                .stream()
                .filter(filter);
    }

    private static <T, R> Stream<R> map(List<T> list, Function<T, R> function) {
        return list
                .stream()
                .map(function);
    }

    public static<T> boolean allMatch(List<T> list, Predicate<T> predicate){
        return list
                .stream()
                .allMatch(predicate);
    }

    public static <T> List<T> filterSortCollect(List<T> list, Predicate<T> filter, Comparator<T> comparator) {
        return filter(list, filter).sorted(comparator)
                .collect(Collectors.toList());
    }

    public static<T> boolean anyMatch(List<T> list, Predicate<T> predicate){
        return list
                .stream()
                .anyMatch(predicate);
    }

    public static <T,R extends Comparable<? super R>> List<R> sortMapCollect(List<T> list,Function<T,R> function){
        list.sort(Comparator.comparing(function));
        return mapCollect(list, function);
    }

    public static <T> void sort(List<T> list, Comparator<T> comparator){
        list.sort(comparator);
    }
}