namespace NancySelfHosting
{
    using Nancy;
    using System;
    using System.Diagnostics;

    public class Module : NancyModule
    {
        public Module()
        {
            Get["/"] = parameters => { return handleQuery(parameters); }; //"Hello World";
        }

        private String handleQuery(dynamic parameters)
        {
            String query = "Query: ";
            query += Request.Url.Query;

            Debug.WriteLine(query);
            return query;
        }
    }
}
