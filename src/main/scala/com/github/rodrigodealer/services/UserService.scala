package com.github.rodrigodealer.services

import com.github.rodrigodealer.models.User

/**
 * Created by rodrigo on 7/5/15.
 */
class UserService {

  var users = Set[User]()

  def create(user: User) = {
    users += user
    user
  }

  def follow(user: User, userToFollow: User) = {
    user.follow(userToFollow)
  }
}
