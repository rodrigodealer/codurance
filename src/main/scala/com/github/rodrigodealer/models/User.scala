package com.github.rodrigodealer.models

/**
 * Created by rodrigo on 7/5/15.
 */
case class User(name: String, var follows: Set[User] = Set[User]()) {
  def follow(user: User) {
    follows = follows + user
  }
}
