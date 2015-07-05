package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.User

/**
 * Created by rodrigo on 7/5/15.
 */
class UserService {

  var users = Set[User]()

  def find(user: User) : Option[User] = {
    users.filter(u => u.name.equals(user.name)) match {
      case userList if userList.size > 0 => Option(userList.head)
      case _ => Option.empty
    }
  }

  def create(user: User) = {
    users += user
    user
  }

  def follow(user: User, userToFollow: User) {
    find(user).get.follow(userToFollow)
  }
}
