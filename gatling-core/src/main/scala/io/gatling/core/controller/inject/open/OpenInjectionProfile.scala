/*
 * Copyright 2011-2019 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.core.controller.inject.open

import java.util.concurrent.atomic.AtomicLong

import io.gatling.commons.util.Clock
import io.gatling.commons.util.Collections._
import io.gatling.core.controller.inject.{ InjectionProfile, Workload }
import io.gatling.core.scenario.Scenario
import io.gatling.core.stats.StatsEngine

import akka.actor.ActorSystem

/**
 * This class represents the configuration of a scenario
 *
 * @param steps the number of users that will behave as this scenario says
 */
final case class OpenInjectionProfile(steps: Iterable[OpenInjectionStep]) extends InjectionProfile {

  override def totalUserCount: Option[Long] = Some(steps.sumBy(_.users))

  override def workload(scenario: Scenario, userIdGen: AtomicLong, startTime: Long, system: ActorSystem, statsEngine: StatsEngine, clock: Clock): Workload =
    new OpenWorkload(scenario: Scenario, UserStream(steps), userIdGen, startTime, system, statsEngine, clock)

  //[fl]
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //[fl]
}
