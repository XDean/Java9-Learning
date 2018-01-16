package xdean.java9;

import java.lang.annotation.Repeatable;

import xdean.java9.VM.Arg;

@Arg(key = "–illegal-access", value = { "permit", "warn", "debug", "deny" })
@Arg(key = "--add-exports",   value = "$module/$package=$readingmodule")
@Arg(key = "--add-opens",     value = "$module/$package=$reflectingmodule")
@Arg(key = "--patch-module",  value = "$module=$artifact")
@Arg(key = "--add-modules",   value = "$modules")
@Arg(key = "--add-reads",     value = "$module=$targets")
public class VM {

  @Repeatable(Args.class)
  public @interface Arg {
    String key();

    String[] value() default "";

    String usage() default "";
  }

  public @interface Args {
    Arg[] value();
  }
}
