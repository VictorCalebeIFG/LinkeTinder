package LinkeTinderAplication.app.API

import LinkeTinderAplication.app.Controller.CandidateController
import jakarta.servlet.ServletException
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import com.fasterxml.jackson.databind.JsonNode

@WebServlet("/Candidate")
class CandidateServlet extends BaseServlet{
    CandidateController controller = new CandidateController()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<List<String>> data = controller.getCandidates().collect(){it.toList()}
        String jsonData = convertListToJson(data)
        sendJsonResponse(resp,jsonData)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonNode json = readJsonRequestBody(req)
        List<String> data = extractValuesFromJson(json)
        controller.addCandidate(data)

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
