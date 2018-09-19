<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="iso-8859-1"%>

<%--
  ~ This file is part of Airsonic.
  ~
  ~  Airsonic is free software: you can redistribute it and/or modify
  ~  it under the terms of the GNU General Public License as published by
  ~  the Free Software Foundation, either version 3 of the License, or
  ~  (at your option) any later version.
  ~
  ~  Airsonic is distributed in the hope that it will be useful,
  ~  but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~  GNU General Public License for more details.
  ~
  ~  You should have received a copy of the GNU General Public License
  ~  along with Airsonic.  If not, see <http://www.gnu.org/licenses/>.
  ~
  ~  Copyright 2015 (C) Sindre Mehus
  --%>

<html><head>
    <%@ include file="head.jsp" %>
    <%@ include file="jquery.jsp" %>

    <script type="text/javascript" language="javascript">
        function refreshPage() {
            location.href = "audiobook.view?id=${model.abook.id}";
        }

        function getSelectedEpisodes() {
            var result = "";
            for (var i = 0; i < ${fn:length(model.files)}; i++) {
                var checkbox = $("#episode" + i);
                if (checkbox.is(":checked")) {
                    result += (checkbox.val() + " ");
                }
            }
            return result;
        }

    </script>
</head>
<body class="mainframe bgcolor1" onload="init()">

<div style="float:left;margin-right:1.5em;margin-bottom:1.5em">
<c:import url="coverArt.jsp">
    <c:param name="audiobookId" value="${model.abook.id}"/>
    <c:param name="coverArtSize" value="200"/>
</c:import>
</div>

<h1 id="name"><a href="audiobooks.view"><fmt:message key="audiobooks.title"/></a> &raquo; ${fn:escapeXml(model.abook.title)}</h1>
<h2>
    <span class="header"><a href="javascript:top.playQueue.onPlayAudiobook(${model.abook.id})"><fmt:message key="common.play"/></a></span>

</h2>

<div class="detail" style="padding-top:0.2em;white-space:normal;width:80%">${fn:escapeXml(model.abook.description)}</div>

<div class="detail" style="padding-top:1.0em">
    <fmt:message key="audiobooks.files"><fmt:param value="${fn:length(model.files)}"/></fmt:message> &ndash;
</div>

<div style="height:0.7em;clear:both"></div>

<table class="music">
    <c:forEach items="${model.abook.audiobookFiles}" var="audiobookFile" varStatus="i">
        <tr>
            <td class="fit"><input type="checkbox" class="checkbox" id="episode${i.index}" value="${audiobookFile.id}"/></td>

            <c:choose>
                <c:when test="${empty audiobookFile.mediaFileId}">
                    <td colspan="4"></td>
                </c:when>
                <c:otherwise>
                    <c:import url="playButtons.jsp">
                        <c:param name="id" value="${audiobookFile.mediaFileId}"/>
                        <c:param name="playEnabled" value="${model.user.streamRole}"/>
                        <c:param name="addEnabled" value="${model.user.streamRole}"/>
                        <c:param name="asTable" value="true"/>
                        <c:param name="onPlay" value="top.playQueue.onPlayAudiobook(${audiobookFile.id})"/>
                    </c:import>
                </c:otherwise>
            </c:choose>

            <td class="fit">
                <span class="detail">${audiobookFile.duration}</span>
            </td>

        </tr>
    </c:forEach>

</table>

</body></html>
