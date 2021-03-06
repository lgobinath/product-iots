/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.coffeeking.api;

import org.wso2.carbon.apimgt.annotations.api.API;
import org.wso2.carbon.apimgt.annotations.api.Permission;
import org.wso2.carbon.device.mgt.extensions.feature.mgt.annotations.DeviceType;
import org.wso2.carbon.device.mgt.extensions.feature.mgt.annotations.Feature;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@API(name = "connectedcup", version = "1.0.0", context = "/connectedcup", tags = {"connectedcup"})
@DeviceType(value = "connectedcup")
public interface ConnectedCupService {

    @Path("device/ordercoffee")
    @POST
    @Feature(code = "ordercoffee", name = "Order Coffee", description = "Order coffee cup")
    @Permission(scope = "connectedcup_user", permissions = {"/permission/admin/device-mgt/user/operations"})
    Response orderCoffee(@QueryParam("deviceId") String deviceId);

    /**
     * Retrieve Sensor data for the device type
     */
    @Path("stats/{deviceId}/sensors/{sensorName}")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Permission(scope = "connectedcup_user", permissions = {"/permission/admin/device-mgt/user/stats"})
    Response getDeviceStats(@PathParam("deviceId") String deviceId, @PathParam("sensorName") String sensor,
                            @QueryParam("from") long from, @QueryParam("to") long to);

    @Path("device/register")
    @POST
    @Permission(scope = "connectedcup_user", permissions = {"/permission/admin/device-mgt/user/devices"})
    boolean register(@QueryParam("name") String name);

}
