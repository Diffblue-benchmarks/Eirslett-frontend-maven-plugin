package com.github.eirslett.maven.plugins.frontend.lib;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

  @Test
  public void testImplode() {
    final String separator = "Bar";
    final List<String> elements = new ArrayList<String>();

    assertEquals("", Utils.implode(separator, elements));

    elements.add("foo");
    elements.add("bar");
    assertEquals("foo bar", Utils.implode(separator, elements));
  }

  @Test
  public void testIsRelative() {
    assertTrue(Utils.isRelative("foo/bar"));

    assertFalse(Utils.isRelative("/foo/bar"));
    assertFalse(Utils.isRelative("file:foo/bar"));
    assertFalse(Utils.isRelative("C:\\SYSTEM"));
  }

  @Test
  public void testMerge() {
    final List<String> first = new ArrayList<String>();
    first.add(null);
    final List<String> second = new ArrayList<String>();
    second.add("a/b/c");
    final List<String> actual = Utils.merge(first, second);

    final List<String> arrayList = new ArrayList<String>();
    arrayList.add(null);
    arrayList.add("a/b/c");

    assertEquals(arrayList, actual);
  }

  @Test
  public void testPrepend() {
    final String first = "A1B2C3";
    final List<String> list = new ArrayList<String>();
    list.add(null);
    final List<String> actual = Utils.prepend(first, list);

    final List<String> arrayList = new ArrayList<String>();
    arrayList.add("A1B2C3");
    arrayList.add(null);

    assertEquals(arrayList, actual);
  }
}
