/*
 * Copyright 2018 Lookout, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.gate.controllers.ecs;

import com.netflix.spinnaker.gate.services.EcsDescribeClustersService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EcsDescribeClustersController {
  @Autowired EcsDescribeClustersService ecsDescribeClustersService;

  @ApiOperation(
      value =
          "Retrieve a list of ECS cluster descriptions that can be used for the account and region.")
  @RequestMapping(value = "/ecs/ecsDescribeClusters", method = RequestMethod.GET)
  List<Map> allEcsClustersDescription(
      @RequestParam(value = "account", required = true) String account,
      @RequestParam(value = "region", required = true) String region) {
    return ecsDescribeClustersService.getAllEcsClustersDescription(account, region);
  }
}
